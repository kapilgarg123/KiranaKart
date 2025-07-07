const BASE_URL = "http://localhost:8080/api";

export const fetchProducts = async () => {
    const response = await fetch(`${BASE_URL}/products`);
    if (!response.ok) {
        throw new Error("Failed to fetch products");
    }
    const data = await response.json();
    return data;
}

export const searchProducts = async (query) => {
    const response = await fetch(`${BASE_URL}/products/search?query=${encodeURIComponent(query)}`);
    if (!response.ok) {
        throw new Error("Failed to fetch search results");
    }
    const data = await response.json();
    return data;
}