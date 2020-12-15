import React from 'react'
import { Link } from 'react-router-dom'

function Header() {
    return (
        <>
            <span className="navbar">
            <Link to="/"><img className="navbar-logo" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQqD9IJwZVQzyR-EEWFIzakgXEmNHBTnZWolA&usqp=CAU" alt="QA Logo" width="45" height="45"/></Link>
            </span>
            <div className="navbar-items">
            <Link to="/" className="item">Home</Link>
            <Link to="/login" className="item">Login</Link>
            </div>
        </>
        )
}

export default Header


