import React from 'react';
import { Link } from 'react-router-dom';
import { useState } from 'react';
import {fetchProducts, searchProducts} from '../services/api';
import "../css/NavBar.css";

export default function NavBar({ onSearch }) {

  const [searchQuery, setSearchQuery] = useState("");

  const handleInputChange = (e) => {
    setSearchQuery(e.target.value);
    if (onSearch) {
      onSearch(e.target.value);
    }
  };


  
  return (
    <nav role="navigation" aria-label="Main navigation">
      <div className="navbar-container">
        <div className="logo">
          <Link to="/">KiranaKart</Link>
        </div>
        <ul className="nav-links">
          <li><Link to="/">Home</Link></li>
          <li><Link to="/products">Products</Link></li>
          <li><Link to="/contact">Contact</Link></li>
        </ul>
        <form className="search-bar" onSubmit={e => e.preventDefault()}>
          <input type="text" placeholder="Search products..." value={searchQuery} onChange={handleInputChange} />
          <button type="submit">Search</button>
        </form>
        <div className="auth-buttons">
          <Link to="/login" className="login-btn">Login</Link>
          <Link to="/signup" className="signup-btn">Sign Up</Link>
        </div>
      </div>
    </nav>
  );
}
