<#
Builds an executable JAR for Employee5 with a manifest Class-Path pointing
to connector JAR(s) in the project root, then runs the JAR.

Place the MySQL connector JAR(s) (e.g. mysql-connector-j-8.4.0.jar) in the
project root next to this script before running.
#>

$project = Split-Path -Parent $MyInvocation.MyCommand.Path
Set-Location $project

$jdkBin = 'C:\Program Files\Java\jdk-24\bin'
$javac = Join-Path $jdkBin 'javac.exe'
$java = Join-Path $jdkBin 'java.exe'
$jar = Join-Path $jdkBin 'jar.exe'

Write-Host "Looking for connector JARs in project root..."
$jars = Get-ChildItem -Filter mysql-connector*.jar -Name
if ($jars.Count -eq 0) {
    Write-Host "No connector JAR found. Put the connector JAR in the project root and re-run this script." -ForegroundColor Red
    exit 1
}

Write-Host "Found: $($jars -join ', ')"

# Compile
Write-Host "Compiling Employee5.java..."
& $javac -cp (".;" + ($jars -join ';')) Employee5.java
if ($LASTEXITCODE -ne 0) { Write-Host "Compilation failed." -ForegroundColor Red; exit $LASTEXITCODE }

# Create manifest file
$manifest = Join-Path $project 'manifest.txt'
"Main-Class: Employee5" | Out-File -Encoding ASCII $manifest
"Class-Path: $($jars -join ' ')" | Out-File -Encoding ASCII -Append $manifest

# Create JAR
if (Test-Path Employee5.jar) { Remove-Item Employee5.jar }
Write-Host "Creating Employee5.jar (manifest references connector jars)..."
& $jar cfm Employee5.jar $manifest Employee5.class
if ($LASTEXITCODE -ne 0) { Write-Host "JAR creation failed." -ForegroundColor Red; exit $LASTEXITCODE }

Write-Host "Running Employee5.jar..."
& $java -jar Employee5.jar
