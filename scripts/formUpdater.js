const resetBtn = document.querySelector("#reset_button");

resetBtn.addEventListener("click", (e)=>{
    confirm("Are you sure you want to clear the form values?") ? mainForm.reset() : false;
});

