set projectLocation=C:\Users\Admin\eclipse-workspace\PrudentialTest

cd %projectLocation%

set classpath=%projectLocation%\bin;%projectLocation%\lib\*;C:\Users\Admin\Desktop\*

java org.testng.TestNG %projectLocation%\AutomationTest.xml
