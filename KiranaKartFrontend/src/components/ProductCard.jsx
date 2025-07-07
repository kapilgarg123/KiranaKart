import React from 'react'
import "../css/ProductCard.css";


export default function ProductCard({ product }) {
  return (
    <div className="bg-white shadow-md rounded-2xl overflow-hidden max-w-xs mx-auto hover:shadow-lg transition-shadow">
      <img
        src={product.image}
        alt={product.name}
        className="w-full h-48 object-cover"
      />
      <div className="p-4">
        <h2 className="text-lg font-semibold text-gray-800">{product.name}</h2>
        <p className="text-sm text-gray-600 mt-1">{product.description}</p>
        <div className="mt-4 flex items-center justify-between">
          <span className="text-xl font-bold text-indigo-600">₹{product.price}</span>
          <button className="bg-indigo-500 text-white px-4 py-1 rounded hover:bg-indigo-600">
            Buy Now
          </button>
        </div>
      </div>
    </div>
  );
}