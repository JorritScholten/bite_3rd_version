import { useEffect, useState } from 'react';
import { get } from './itemServices';
import { formatAsPrice, omit, toInternalCentPrices } from './utils';
import Basket from './Basket';
import { Link } from 'react-router-dom'

const Order = () => {
    const [items, setItems] = useState([]);
    const [basket, setBasket] = useState({});

    const addToBasket = id => setBasket({ ...basket, [id]: (basket[id] ?? 0) + 1 });

    const removeFromBasket = id => {
        if (!basket[id]) return;
        setBasket(basket[id] === 1 ? omit(id, basket) : { ...basket, [id]: basket[id] - 1 });
    }

    useEffect(() => {
        get().then(response => response.json())
            .then(actualData => setItems(toInternalCentPrices(actualData)))
            .catch(err => console.log(`An error has occurred: ${err.message}.`))
    }, []);

    return <>
        <p>Order!</p>
        <Link to="/manage">Manage the stocks...</Link>
        <ol>
            {items.map(item => <li key={item.id}>{item.name} {formatAsPrice(item.price)}
                <button onClick={() => addToBasket(item.id)}>Add to basket!</button>
                <button onClick={() => removeFromBasket(item.id)}>Remove from basket!</button></li>)}
        </ol>
        <Basket items={items} basket={basket} />

    </>
    // note: <AddItem {...{reloadItems}} /> also works, but may be too unconventional for readability, {reloadItems} itself does NOT work
}

export default Order;

