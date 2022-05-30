import api from '../api';

async function getAllCustomers() {
  const response = await api
    .get('/customers')
    .then((response) => (response.data))
    .catch((err) => ({ error: err.response.data.message }));
  return response;
}

export default getAllCustomers;