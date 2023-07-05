import './App.css'
import { useEffect, useState } from 'react';
import AddItem from './AddItem';
import { deleteById } from './itemServices';

const formatAsPrice = new Intl.NumberFormat("nl-NL", { style: "currency", currency: "EUR" }).format;

const App = () => {
  const [items, setItems] = useState([]);
  const [versionGuid, updateVersionGuid] = useState(0)

  const reloadItems = () => updateVersionGuid(versionGuid + 1)

  const deleteItem = id => deleteById(id).then(reloadItems);

  useEffect(() => {
    fetch(`http://localhost:8080/api/v1/items`)
      .then(response => response.json())
      .then(actualData => setItems(actualData))
      .catch(err => console.log(`An error has occurred: ${err.message}.`))
  }, [versionGuid]);

  return <>
    <ol>
      {items.map(item => <li key={item.id}>{item.name} {formatAsPrice(item.price)}<button onClick={() => deleteItem(item.id)}>Delete</button></li>)}
    </ol>
    <AddItem reloadItems={reloadItems} />
  </>
}

export default App
