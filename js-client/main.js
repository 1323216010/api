import Axios from 'axios'

const axios = Axios.create({
    baseURL: 'http://localhost:8081'
})

axios.interceptors.response.use(res => {
    return  Promise.resolve(res.data)
})

axios.get('/poet', {params: {author: "李白"}}).then( res => {
    console.log(res)
})

var token = 'eyJhbGciOiJIUzUxMiJ9.eyJsb2dpbl91c2VyX2tleSI6ImY1NGFmN2UwLWY1M2YtNDlkNy1iZWM5LWEzMTZkM2E2ZTUwOSJ9.jRDJuRoVsCMEaT-SefzvkrgH9b6FMoArPqMfPvg44P4wq1GMzx6sLmxIMp79gztSuwWk8liIlkFaFN3iXJfC0g'
axios.defaults.headers.common['Authorization'] = `Bearer ${token}`;

axios.post('/poet', {params: {author: ""}}).then( res => {
    console.log(res)
})
