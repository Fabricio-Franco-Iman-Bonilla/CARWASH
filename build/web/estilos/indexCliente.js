function changePrices(vehicleType) {
    let prices = {
        sedan: { standard: 20, basic: 30, management: 40, salon: 250 },
        'suv-small': { standard: 25, basic: 35, management: 45, salon: 260 },
        'suv-medium': { standard: 30, basic: 40, management: 50, salon: 270 },
        'suv-large': { standard: 35, basic: 45, management: 55, salon: 280 },
        moto: { standard: 15, basic: 25, management: 35, salon: 240 }
    };

    let selectedPrices = prices[vehicleType];

    document.getElementById('price-standard').innerText = selectedPrices.standard.toFixed(2);
    document.getElementById('price-basic').innerText = selectedPrices.basic.toFixed(2);
    document.getElementById('price-management').innerText = selectedPrices.management.toFixed(2);
    document.getElementById('price-salon').innerText = selectedPrices.salon.toFixed(2);
}
