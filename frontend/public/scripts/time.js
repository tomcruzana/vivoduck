const clock = document.getElementById("clock");
setInterval(() => {
  const today = new Date();
  const time =
    `<i class="fa fa-clock-o" aria-hidden="true"></i> Time: ${today.getHours()} : ${today.getMinutes()} : ${today.getSeconds()}`;
  clock.innerHTML = time;
}, 1000);
