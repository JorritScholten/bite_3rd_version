async function postData(url, data) {
  // Default options are marked with *
  const response = await fetch(url, {
    method: "POST", // *GET, POST, PUT, DELETE, etc.
    mode: "cors", // no-cors, *cors, same-origin
    cache: "no-cache", // *default, no-cache, reload, force-cache, only-if-cached
    credentials: "same-origin", // include, *same-origin, omit
    headers: {
      "Content-Type": "application/json",
    },
    redirect: "follow", // manual, *follow, error
    referrerPolicy: "no-referrer", // no-referrer, *no-referrer-when-downgrade, origin, origin-when-cross-origin, same-origin, strict-origin, strict-origin-when-cross-origin, unsafe-url
    body: JSON.stringify(data), // body data type must match "Content-Type" header
  });
  return response.json(); // parses JSON response into native JavaScript objects
}

const formatAsPrice = (priceInCents) =>
  new Intl.NumberFormat("nl-NL", { style: "currency", currency: "EUR" }).format(
    priceInCents / 100
  );

// from https://stackoverflow.com/questions/34698905/how-can-i-clone-a-javascript-object-except-for-one-key
const omit = (prop, { [prop]: _, ...rest }) => rest;

const toInternalCentPrices = (items) =>
  items.map((item) => ({ ...item, price: item.price * 100 }));

export { formatAsPrice, omit, postData, toInternalCentPrices };
