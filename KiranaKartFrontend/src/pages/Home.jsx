import React, { useState, useEffect } from "react";
import ProductCard from "../components/ProductCard";
import NavBar from "../components/NavBar";
import { fetchProducts, searchProducts } from "../services/api";

function Home() {
  const [products, setProducts] = useState([]);
  

  useEffect(() => {
    fetchProducts()
      .then(setProducts)
      .catch((err) => {
        console.error("Failed to fetch products:", err);
        setProducts([]);
      });
  }, []);

  const handleSearch = async (query) => {
    if (!query.trim()) {
      try {
        const allProducts = await fetchProducts();
        setProducts(allProducts);
      } catch (err) {
        console.error("Failed to fetch products:", err);
        setProducts([]);
      }
        return;
    }
    try {
      const results = await searchProducts(query);
      setProducts(results);
    } catch (err) {
      console.error("Search failed:", err);
      setProducts([]);
    }
  };

  return (
    <div className="min-h-screen bg-gray-100 p-4">
      <NavBar onSearch={handleSearch} />
      <div className="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-4 gap-6">
        {products.map((product) => (
          <ProductCard key={product.id} product={product} />
        ))}
      </div>
    </div>
  );
}
export default Home;
