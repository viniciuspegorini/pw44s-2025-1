import './App.css'
import {HomePage} from "@/pages/home";
import {RegisterPage} from "@/pages/register";
import {LoginPage} from "@/pages/login";

function App() {

    return (
        <>
            <HomePage />
            <RegisterPage />

            <LoginPage />
        </>
    )
}

export default App