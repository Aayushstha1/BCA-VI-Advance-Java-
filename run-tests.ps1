# Automated tests for FactorialServer
# Usage: Open PowerShell in this folder and run: .\run-tests.ps1

function Wait-ForServer {
    param(
        [string]$Url = 'http://localhost:8080/factorial',
        [int]$TimeoutSec = 10
    )
    $start = [DateTime]::UtcNow
    while (([DateTime]::UtcNow - $start).TotalSeconds -lt $TimeoutSec) {
        try {
            $r = Invoke-WebRequest -Uri $Url -Method GET -UseBasicParsing -TimeoutSec 2
            if ($r.StatusCode -eq 200) { return $true }
        } catch {
            Start-Sleep -Milliseconds 200
        }
    }
    return $false
}

# Compile
Write-Host "Compiling FactorialServer.java..." -ForegroundColor Cyan
javac FactorialServer.java
if ($LASTEXITCODE -ne 0) {
    Write-Error "Compilation failed. Fix compile errors and retry."
    exit 1
}

# Start server
Write-Host "Starting server..." -ForegroundColor Cyan
$proc = Start-Process -FilePath java -ArgumentList 'FactorialServer' -PassThru
try {
    if (-not (Wait-ForServer -TimeoutSec 10)) {
        Write-Error "Server did not become available within timeout."
        Stop-Process -Id $proc.Id -Force -ErrorAction SilentlyContinue
        exit 1
    }

    Write-Host "Server is up. Running tests..." -ForegroundColor Green

    $tests = @(
        @{ name = 'GET form'; method='GET'; url='http://localhost:8080/factorial'; body=$null; expect='Factorial Calculator'; type='contains' },
        @{ name = 'POST 5'; method='POST'; url='http://localhost:8080/factorial'; body=@{number='5'}; expect='120'; type='equals' },
        @{ name = 'POST 0'; method='POST'; url='http://localhost:8080/factorial'; body=@{number='0'}; expect='1'; type='equals' },
        @{ name = 'POST -1'; method='POST'; url='http://localhost:8080/factorial'; body=@{number='-1'}; expect='Please enter a non-negative integer.'; type='equals' },
        @{ name = 'POST abc'; method='POST'; url='http://localhost:8080/factorial'; body=@{number='abc'}; expect='Invalid number: abc'; type='equals' },
        @{ name = 'POST 10001'; method='POST'; url='http://localhost:8080/factorial'; body=@{number='10001'}; expect='Number too large. Please enter a smaller value (<= 10000).'; type='equals' },
        @{ name = 'POST 20'; method='POST'; url='http://localhost:8080/factorial'; body=@{number='20'}; expect='2432902008176640000'; type='equals' }
    )

    $allPassed = $true
    foreach ($t in $tests) {
        try {
            if ($t.method -eq 'GET') {
                $resp = Invoke-RestMethod -Uri $t.url -Method Get -UseBasicParsing
            } else {
                $resp = Invoke-RestMethod -Uri $t.url -Method Post -Body $t.body -ContentType 'application/x-www-form-urlencoded' -UseBasicParsing
            }

            if ($t.type -eq 'contains') {
                $passed = $resp -like "*${($t.expect)}*"
            } else {
                $passed = ($resp -eq $t.expect)
            }

            if ($passed) {
                Write-Host "[PASS] $($t.name)" -ForegroundColor Green
            } else {
                Write-Host "[FAIL] $($t.name) - expected: '$($t.expect)' got: '$resp'" -ForegroundColor Red
                $allPassed = $false
            }
        } catch {
            Write-Host "[ERROR] $($t.name) - $_" -ForegroundColor Red
            $allPassed = $false
        }
    }

    if ($allPassed) {
        Write-Host "All tests passed ✅" -ForegroundColor Green
        exit 0
    } else {
        Write-Error "Some tests failed."; exit 1
    }
} finally {
    if ($proc -and $proc.Id) {
        Try { Stop-Process -Id $proc.Id -Force -ErrorAction SilentlyContinue } Catch {}
    }
}
