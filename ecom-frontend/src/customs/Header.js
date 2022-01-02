import {Link} from 'react-router-dom';

function Header(){

    const isUserLoggedIn = false;

    return (
        <header>
            <nav className='navbar navbar-expand-md navbar-dark bg-dark'>
                EComApp
                <ul className='navbar-nav'>
                    {isUserLoggedIn && <li><Link to="/welcome/raghav" className='nav-link'>Home</Link></li>}
                    {isUserLoggedIn && <li><Link to="/orders" className='nav-link'>Orders</Link></li>}
                </ul>
                <ul className='navbar-nav navbar-collapse justify-content-end'>
                    {!isUserLoggedIn && <li><Link to="/login" className='nav-link'>Login</Link></li>}
                    {isUserLoggedIn && <li><Link to="/logout" className='nav-link'>Logout</Link></li>}
                </ul>
            </nav>
        </header>
    );
}

export default Header;