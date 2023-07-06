import { postData } from './utils';

const basePath = `http://localhost:8080/api/v1/items`;

const post = item => postData(basePath, item);

const get = () => fetch(basePath);

const deleteById = id => fetch(`${basePath}/${id}`, { method: "DELETE" })

export { get, post, deleteById }