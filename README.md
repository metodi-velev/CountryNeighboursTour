# CountryNeighboursTour
Test Case:  Bulgaria has 5 neighbor countries (TR, GR, MK, SR, RO) <br>
Angel fills in the following request values: • Starting country: Bulgaria (BG) • Budget per country: 100 • Total budget: 1200 • Currency: EUR
<br>
POST: http://localhost:8080/country-trip/countries   <br>
{
	"name":"BG",
	"currency":"LEV",
	"exchangeRate": 1.96
}
<br>
{
	"name":"MK",
	"currency":"MKD",
	"exchangeRate": 61.54
}
<br>
{
	"name":"SR",
	"currency":"RSD",
	"exchangeRate": 117.72
}
<br>
{
	"name":"RO",
	"currency":"RON",
	"exchangeRate": 4.84
}
<br>
{
		"name":"TR",
		"currency":"TL",
		"exchangeRate": 7.57
}
<br>
{
	"name":"GR",
	"currency":"EUR",
	"exchangeRate": 1.00
}

GET: http://localhost:8080/country-trip/countries/1/neighbours/2 
<br>
GET: http://localhost:8080/country-trip/countries/1/neighbours/3
<br>
GET: http://localhost:8080/country-trip/countries/1/neighbours/4
<br>
GET: http://localhost:8080/country-trip/countries/1/neighbours/5
<br>
GET: http://localhost:8080/country-trip/countries/1/neighbours/6
<br>
GET: http://localhost:8080/country-trip/countries?start=BG&budgetPerCountry=100.0&totalBudget=1130.5&currency=EUR&exchangeRate=1.5
<br>
Response:
<br>
{
<br>
   &emsp; "neighbours": [
        "GR",
        "RO",
        "MK",
        "TR",
        "SR"
    ], 
    <br>
  &emsp;  "numNeighbours": 5,
    <br>
  &emsp;  "roundtrips": 2,
    <br>
  &emsp; "leftover": 130.5,
    <br>
  &emsp; "budgetPerCountry": {
        "GR": 100.0,
        "RO": 484.0,
        "TR": 757.0,
        "MK": 6154.0,
        "SR": 11772.0
    }
    <br>
}
<br>
GET: http://localhost:8080/country-trip/countries/all
