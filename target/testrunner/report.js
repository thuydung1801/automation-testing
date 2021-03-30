$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/BackEnd/instockItemSuite.feature");
formatter.feature({
  "name": "",
  "description": "",
  "keyword": "Feature"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "Go to adminPage url",
  "keyword": "Given "
});
formatter.match({
  "location": "BasePageSteps.goToUrl(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Insert thanh.tester into box have id: emailAdmin",
  "keyword": "When "
});
formatter.match({
  "location": "BasePageSteps.insertId(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Insert !test123! into box have id: passAdmin",
  "keyword": "And "
});
formatter.match({
  "location": "BasePageSteps.insertId(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Click button by class signInBtn",
  "keyword": "And "
});
formatter.match({
  "location": "BasePageSteps.clickButtonByClass(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Successfully into DashboardPage front site",
  "keyword": "Then "
});
formatter.match({
  "location": "BasePageSteps.Successfully(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Test01"
    }
  ]
});
formatter.step({
  "name": "Go to ManageInstockRequest url",
  "keyword": "Given "
});
formatter.match({
  "location": "BasePageSteps.goToUrl(String)"
});
formatter.result({
  "status": "passed"
});
});