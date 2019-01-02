/*
References:
https://developers.google.com/apps-script/guides/html/
https://developers.google.com/apps-script/guides/web#deploying
//https://developers.google.com/apps-script/guides/ui-service
https://developers.google.com/apps-script/guides/html/reference/run#withSuccessHandler(Function)
https://stackoverflow.com/questions/16525553/get-value-of-html-text-box-in-apps-script-function
https://www.color-hex.com/
*/

function doGet() {
  return HtmlService.createHtmlOutputFromFile('index'); //declare as web app
}

var sheet = SpreadsheetApp.getActiveSpreadsheet().getSheetByName("Sheet1"); //gets the name of the sheet
var cell = sheet.getCurrentCell();

function selectCell(formObject)
{
  //for code reuse!
  var val0 = formObject['location_txt'];
  var val1 = formObject['machineInfo_txt'];
  var val2 = formObject['vivonetPO_txt'];
  var val3 = formObject['ScOrderNumber_txt'];
  var val4 = formObject['ScPO_txt'];
  var val5 = formObject['trackingInfo_txt'];
  var val6 = formObject['remarks_txt'];
  var val7 = formObject['serials_txt'];
  var val8 = formObject['cdSerials_txt'];
  var val9 = formObject['macAddress_txt'];
  var val10 = formObject['SO_txt'];


  var values = [val0, val1,val2,val3,val4,val5,val6,val7,val8,val9,val10];
  
  //insert for loop here if you have terminals that are alike in the same order!
  
  if (cell)
  {
   sheet.appendRow([ values[0], values[1], values[2],values[3] , values[4],values[5] ,values[6] ,values[7] ,values[8] ,values[9] ,values[10]]);
  //cell.setBackgroundRGB(252, 200, 12);
  }
  
}
