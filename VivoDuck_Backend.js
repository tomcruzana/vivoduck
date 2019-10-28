function doGet() //declare as a Google web app
{
  return HtmlService
      .createTemplateFromFile('index')
      .evaluate()
}

var sheet = SpreadsheetApp.getActiveSpreadsheet().getSheetByName("Sheet1"); //get the name of the sheet
var cell = sheet.getCurrentCell(); //get active cell

function retrieveRow() //This feature is a work in progress. Function for retrieving rows
{
  var temp = sheet.getRange("A1:C1").getValues(); 
  Logger.log(temp);
  return temp;
}

function selectCell(formObject)
{
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
  
  if (cell)
  {
   sheet.appendRow([ values[0], values[1], values[2],values[3] , values[4],values[5] ,values[6] ,values[7] ,values[8] ,values[9] ,values[10]]); //Appends the values into the cell rows.
  }
}
