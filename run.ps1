<#
Simple helper to compile & run Employee5 with MySQL connector jars.
Usage: Right-click -> Run with PowerShell, or from PowerShell: .\run.ps1
#>

$project = Split-Path -Parent $MyInvocation.MyCommand.Path
Set-Location $project

$javac = 'C:\\Program Files\\Java\\jdk-24\\bin\\javac.exe'
$java  = 'C:\\Program Files\\Java\\jdk-24\\bin\\java.exe'

$jars = @()
if (Test-Path 'mysql-connector-j-8.4.0.jar') { $jars += 'mysql-connector-j-8.4.0.jar' }
if (Test-Path 'mysql-connector-java.jar') { $jars += 'mysql-connector-java.jar' }
if ($jars.Count -eq 0) {
    Write-Host "No MySQL connector JAR found in project root. Please put connector JAR here (e.g. mysql-connector-java-8.1.0.jar)."
    exit 1
}

$cp = ".;" + ($jars -join ';')

Write-Host "Compiling Employee5.java..."
& $javac -cp $cp Employee5.java
if ($LASTEXITCODE -ne 0) { Write-Host "Compilation failed."; exit $LASTEXITCODE }

Write-Host "Running Employee5 (press Ctrl+C to stop)."
& $java -cp $cp Employee5