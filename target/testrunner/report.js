$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/MyTest.feature");
formatter.feature({
  "name": "As a user, i want to login into the Mektoube",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "login successfully",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@test01"
    }
  ]
});
formatter.step({
  "name": "Go to \u0027https://mektoube.fr/login\u0027 url",
  "keyword": "Given "
});
formatter.match({
  "location": "DefinitionSteps.goToUrl(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Insert \u0027yassine_yes\u0027 into the Email field",
  "keyword": "When "
});
formatter.match({
  "location": "DefinitionSteps.insertAIntoTheEmailField(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Insert \u0027Mektoubi2017\u0027 into the Password field",
  "keyword": "When "
});
formatter.match({
  "location": "DefinitionSteps.insertAIntoThePasswordField(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Click login button",
  "keyword": "When "
});
formatter.match({
  "location": "DefinitionSteps.clickLoginButton()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User login successfully into \u0027https://mektoube.fr/main/discoveries\u0027 front site",
  "keyword": "Then "
});
formatter.match({
  "location": "DefinitionSteps.userLoginSuccessfullyIntoHttpsMektoubeFrMainDiscoveriesFrontSite(String)"
});
formatter.result({
  "status": "passed"
});
});