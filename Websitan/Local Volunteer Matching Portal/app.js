document.addEventListener("DOMContentLoaded", function() { // Runs after the document is fully loaded
    const hoursForm = document.querySelector("form"); // Selects the hours logging form
    hoursForm.addEventListener("submit", function(event) { // Handles form submission
        event.preventDefault(); // Prevents form from refreshing the page
        const date = document.getElementById("date").value; // Gets the date input
        const hours = document.getElementById("hours").value; // Gets the hours input

        let logs = JSON.parse(localStorage.getItem("hourLogs")) || []; // Retrieves saved logs or sets an empty array
        logs.push({ date, hours }); // Adds the new entry to the logs
        alert("Hours logged successfully!"); // Alerts user of success

        displayLogs(); // Updates the displayed logs
    });

    function displayLogs() { // Displays logged entries on the page
        const logs = JSON.parse(localStorage.getItem("hourLogs")) || []; // Retrieves saved logs
        const logContainer = document.getElementById("logContainer"); // Selects container to display logs
        logContainer.innerHTML = logs.map(log => `<p>${log.date} - ${log.hours} hours</p>`).join(''); // Creates log entries in HTML
    }

    displayLogs(); // Calls display function to show logs on page load
});
