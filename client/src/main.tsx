import {StrictMode} from 'react'
import {createRoot} from 'react-dom/client'
import './index.css'
import App from './App.tsx'
import {PrimeReactProvider} from "primereact/api";

import 'primeicons/primeicons.css'
import 'primeflex/primeflex.css';

import {BrowserRouter} from "react-router-dom";
import {HomePage} from "@/pages/home";

createRoot(document.getElementById('root')!).render(
    <StrictMode>
        <BrowserRouter>
            <PrimeReactProvider>
                <App/>
                <HomePage />
            </PrimeReactProvider>
        </BrowserRouter>
    </StrictMode>,
)
