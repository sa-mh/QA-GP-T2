import React from 'react'
import logo from '../Reasources/logo.svg'
import { Link, Router } from 'react-router-dom'

function Header() {
    return (
        <>
            <div>
                <Link to="/">Home</Link>
                <Link to="/login">Login</Link>
                <Link to="/about">About</Link>
            </div>
        </>
        )
}

export default Header


