// Function to validate form inputs and show trip summary in a prompt
function validateAndShowSummary() {
    const name = document.getElementById('name').value;
    const destination = document.getElementById('destination').value;
    const budget = document.getElementById('budget').value;
    const beachChecked = document.getElementById('beach').checked;
    const mountainChecked = document.getElementById('mountain').checked;
    const cityChecked = document.getElementById('city').checked;

    // Validate inputs
    if (!name.trim()) {
        alert('Please enter your full name.');
        return;
    }

    if (destination === '') {
        alert('Please select a destination.');
        return;
    }

    if (isNaN(parseFloat(budget)) || parseFloat(budget) <= 0) {
        alert('Please enter a valid budget amount.');
        return;
    }

    if (!beachChecked && !mountainChecked && !cityChecked) {
        alert('Please select at least one travel preference.');
        return;
    }

    // Construct trip summary message
    const preferences = [];
    if (beachChecked) preferences.push('Beach');
    if (mountainChecked) preferences.push('Mountain');
    if (cityChecked) preferences.push('City');

    const formattedPreferences = preferences.join(', ');
    const summaryMessage = `Hello ${name}!\n\nYour trip to ${destination} is planned.\n\nBudget: $${budget}\nPreferences: ${formattedPreferences}`;

    // Show trip summary in a prompt
    const confirmation = confirm(`${summaryMessage}\n\nClick OK to confirm your trip.`);
    if (confirmation) {
        alert('Trip confirmed. Have a great journey!');
    } else {
        alert('Trip not confirmed. Feel free to plan again.');
    }
}

// Add click event listener to the "Plan My Trip" button
const planTripButton = document.getElementById('planTripButton');
planTripButton.addEventListener('click', validateAndShowSummary);
