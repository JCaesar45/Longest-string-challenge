# main.py
from fastapi import FastAPI, HTTPException
from pydantic import BaseModel
from typing import List
import uvicorn

app = FastAPI(title="Aegis Prime Python Microservice")

class Product(BaseModel):
    tier: str
    name: str
    price: str
    features: List[str]

PRODUCTS_DB = [
    Product(tier="Tier I", name="Aegis Core", price="$4,500", features=["256-bit AES Hardware Encryption", "Biometric Multi-Factor Auth", "Air-Gapped Transaction Signing", "Titanium Chassis"]),
    Product(tier="Tier II", name="Aegis Prime", price="$12,000", features=["Post-Quantum Lattice Cryptography", "Decentralized Mesh Networking", "Zero-Knowledge Proof Engine", "Sapphire Glass Interface"]),
    Product(tier="Tier III", name="Aegis Sovereign", price="$45,000", features=["Custom Silicon Secure Enclave", "Satellite Uplink Capability", "Autonomous Threat Neutralization", "Bespoke Artisan Assembly"])
]

@app.get("/api/products", response_model=List[Product])
async def get_products():
    return PRODUCTS_DB

@app.get("/api/products/{product_name}", response_model=Product)
async def get_product(product_name: str):
    for product in PRODUCTS_DB:
        if product.name.lower() == product_name.lower():
            return product
    raise HTTPException(status_code=404, detail="Product not found")

if __name__ == "__main__":
    uvicorn.run(app, host="0.0.0.0", port=8000)
