const cannedResponseTextArea = document.querySelector("#cannedResponse_txt");

document.querySelector("#update_button").addEventListener("click", (e)=>{
    getCannedResponse(); //this is a temporary event listener. This should couple with update spreadsheet function
    alert("Success");
});

//generate canned response for email
function getCannedResponse(){
    cannedResponseTextArea.scrollIntoView({ behavior: 'smooth', block: 'center' });   
    let machineInfo = document.getElementById("machineinfo").value;
    let location = document.getElementById("location").value;
    let message = "Hello,\nThis order is ready for staging:\n" + location + " | " + machineInfo + " | " 
                    + "newstore-X.~new.support"
                    + "\nPlease let us know if you need anything else\nThank you.";
    
    document.getElementById("cannedResponse_txt").value = message;
}
    
//copy texts to clipboard
function copyToClipBoard(){
    let copyText = document.getElementById("cannedResponse_txt");
    copyText.select();
    document.execCommand("copy");
    alert("Successfully Copied to Clipboard");
}