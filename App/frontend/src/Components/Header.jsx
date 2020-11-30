import React from 'react'
import logo from '../Reasources/logo.svg'
import { Link } from 'react-router-dom'

function Header() {
    return (
        <div>
            <header>
                <nav className="navbar">

                    <a
                        href="https://www.qa.com"
                        className="navbar-logo"
                        target="_blank"
                        rel="noopener noreferrer"
                    >
                        <img src={logo} alt="QA Ltd" style={{ width: '100px' }} />
                    </a>

                    <ul>
                        <li className='nav-item'>
                            Home
                        </li>
                        <li className='nav-item'>
                            Login
                        </li>
                    </ul>
                    <hr></hr>
                </nav>
            </header>
        </div>
    )
}

export default Header
