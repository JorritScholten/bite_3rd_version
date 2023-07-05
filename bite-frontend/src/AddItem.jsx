import { useState } from 'react';
import { postData } from './utils';
import PropTypes from 'prop-types';

const AddItem = props => {
    const defaultState = { name: "", price: "" }
    const [item, setItem] = useState({ ...defaultState });

    const submit = event => {
        event.preventDefault();
        console.log(item);
        postData(`http://localhost:8080/api/v1/items`, item).then(() => {
            setItem({ ...defaultState });
            props.reloadItems();
        })
    }

    const change = event => {
        const { name, value } = event.target;
        setItem({ ...item, [name]: value });
    }

    return (<>
        <form onSubmit={submit}>
            <input type="text" name="name" value={item.name} onChange={change} />
            <input type="text" name="price" value={item.price} onChange={change} />
            <input type="submit"></input>
        </form>
    </>)
}

AddItem.propTypes = {
    reloadItems: PropTypes.func.isRequired
}

export default AddItem;