import Axios from 'axios'

const axios = Axios.create({
    baseURL: 'http://localhost:8081'
})

axios.interceptors.response.use(res => {
    return  Promise.resolve(res.data)
})


axios.get('/poet?author=李白').then( res => {
    console.log(res)
})