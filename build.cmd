call .\set-env.cmd

call "%M2%\mvn.bat" clean install -Dmaven.test.skip -Dproject.build.sourceEncoding=cp1253 > build.log 2>&1
REM "C:\Program Files\Notepad++\notepad++.exe" build.log
