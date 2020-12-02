import React from 'react'
import { Link } from 'react-router-dom'

function Header() {
    return (
        <>
            <span className="navbar">
            <Link to="/"><img className="navbar-logo" src="https://qa-community.co.uk/static/qa_fill_primary.svg" alt="QA Logo" width="64" height="64"/></Link>
            </span>
            <div className="navbar">
            <Link to="/login">Login</Link>
            <Link to="/about">About</Link>
            </div>
        </>
        )
}

export default Header


