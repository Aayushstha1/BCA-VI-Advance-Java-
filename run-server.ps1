# Compile and run the FactorialServer (PowerShell)
javac FactorialServer.java
if ($LASTEXITCODE -ne 0) {
    Write-Error "Compilation failed. Check errors above."
    exit 1
}

Write-Host "Starting FactorialServer... (http://localhost:8080/factorial)" -ForegroundColor Green
java FactorialServer
