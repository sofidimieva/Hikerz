import http from 'k6/http';
import { check, sleep } from 'k6';
import { htmlReport } from "https://raw.githubusercontent.com/benc-uk/k6-reporter/main/dist/bundle.js";
import { textSummary } from "https://jslib.k6.io/k6-summary/0.0.1/index.js";


export let options = {
  stages: [
    { duration: '15s', target: 50 },
    { duration: '30s', target: 50 },
    { duration: '15s', target: 100 },
    { duration: '30s', target: 100 },
    { duration: '15s', target: 200 },
    { duration: '30s', target: 200 },
    { duration: '15s', target: 400 },
    { duration: '30s', target: 400 },
    { duration: '15s', target: 800 },
    { duration: '30s', target: 800 },
    { duration: '15s', target: 1000 },
    { duration: '30s', target: 1000 },
  ],
  thresholds: {
    'http_req_duration': ['p(95)<1000'],
  },
};

export default function () {
  const url = 'http://localhost:8090/api/user/all/user1?page=0&size=10';
  const res = http.get(`${url}`);

  if (res.status !== 200) {
    console.error(`Request failed with status ${res.status}`);
  }

  sleep(1);
}