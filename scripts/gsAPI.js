/*
	Docs:
		QS:
		https://developers.google.com/sheets/api/quickstart/nodejs
		
		APPENDING DATA:
		https://gist.github.com/iaincollins/43302ea047d4a77e6605350598d160c1
		https://developers.google.com/sheets/api/reference/rest/v4/spreadsheets.values/append
		
		READING DATA:
		https://developers.google.com/sheets/api/reference/rest/v4/spreadsheets.values/get
*/

const {google} = require("googleapis");
const keys = require("../keys");
const sheetID = "1Au51cENUnyedN8djQGNlRFQOJBUvdhKVE4iUYOuV9MQ";

//credential settings
const client = new google.auth.JWT(
	keys.client_email,
	null,
	keys.private_key,
	["https://www.googleapis.com/auth/spreadsheets"]
);

//authenticate credentials and call back a google sheet operation function
function authenticate(gs, newValues){ //new values is the query string obj from the form
	client.authorize((err, tokens)=>{
		if(err){
			console.log(err);
			return;
		} 
		else{
			console.log("success");
			//excecute gs operation!
			gs(client, newValues);
		}
	});
}

//authenticate(gsAppend);

//read data --add a range param
async function gsRead(client) {
	const gsapi = google.sheets({ version: "v4", auth: client });
	
	const readSettings = {
		spreadsheetId: sheetID, 
		range: "A2:K2"
	};
	
	let data = await gsapi.spreadsheets.values.get(readSettings);
	console.log(data.data.values); //read spreadsheet values
}

//append data
async function gsAppend(client, newValues) {
	const gsapi = google.sheets({ version: "v4", auth: client });
	
	const appendSettings = {
		spreadsheetId: sheetID, 
		range: "A1", //gs will write values to the next empty row no matter what
		valueInputOption: "USER_ENTERED",
		insertDataOption: "INSERT_ROWS",
		resource: {
			values: [
				//values to be written
				Object.values(newValues) //convert query obj to strings
			]
		}
	};
	
	let res = await gsapi.spreadsheets.values.append(appendSettings);
	console.log(res); //update spreadsheet values
}

//edit existing data function

module.exports = {
   authenticate: authenticate,
   gsRead: gsRead,
   gsAppend: gsAppend  
};
