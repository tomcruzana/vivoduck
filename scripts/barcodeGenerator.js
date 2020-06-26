//global variables
const form = document.getElementById("myForm");
const printBtn = document.querySelector("#printer");
const labelPopup = document.querySelector("#label-popup");
const labelElements = ["#location-label", "#machine-info-label", "#vivonet-po", "#serial-label", "#mac-label", "#so-label"];
const texts = ["Location", "Machine Information", "Vivonet PO", "Serial #", "MAC Address", "SO"];
const fontOptions = "bold";
const width = 1.5;
const height = 25;
const textPosition = "bottom";
const textMargin = 10;
const fontSize = 20;

printBtn.addEventListener("click", ()=>{
	getFormValues(["location_txt", "machineInfo_txt", "vivonetPO_txt", "serials_txt", "macAddress_txt", "SO_txt"])
});

//fetch input box values and pass to generate barcode labels
function getFormValues(formNames){
	let texts = [];
	formNames.forEach( (n, i) => texts.push(form.elements[formNames[i]].value.toString()));
	generateAndPrintLabel(texts);
}

//generate labels
function generateAndPrintLabel(t){
    for (let i = 0; i < labelElements.length; i++) {
        JsBarcode(labelElements[i], t[i], {
            fontOptions: fontOptions,
            width: width,
            height: height,
            textPosition: textPosition,
            textMargin: textMargin,
            fontSize: fontSize
            });
}
labelPopup.style.display = "block";
labelPopup.nextElementSibling.scrollIntoView({ behavior: 'smooth', block: 'end' });  //fix the render bug
setTimeout(()=> window.print(), 2000); //call print dialog box
}