// server.ts
import express, { Request, Response, NextFunction } from 'express';
import cors from 'cors';

interface Product {
    tier: string;
    name: string;
    price: string;
    features: string[];
}

const app = express();
const PORT = process.env.PORT || 3000;

app.use(cors());
app.use(express.json());

const products: Product[] = [
    { tier: "Tier I", name: "Aegis Core", price: "$4,500", features: ["256-bit AES Hardware Encryption", "Biometric Multi-Factor Auth", "Air-Gapped Transaction Signing", "Titanium Chassis"] },
    { tier: "Tier II", name: "Aegis Prime", price: "$12,000", features: ["Post-Quantum Lattice Cryptography", "Decentralized Mesh Networking", "Zero-Knowledge Proof Engine", "Sapphire Glass Interface"] },
    { tier: "Tier III", name: "Aegis Sovereign", price: "$45,000", features: ["Custom Silicon Secure Enclave", "Satellite Uplink Capability", "Autonomous Threat Neutralization", "Bespoke Artisan Assembly"] }
];

app.get('/api/products', (req: Request, res: Response) => {
    res.status(200).json(products);
});

app.get('/api/products/:name', (req: Request, res: Response) => {
    const product = products.find(p => p.name.toLowerCase() === req.params.name.toLowerCase());
    if (product) {
        res.status(200).json(product);
    } else {
        res.status(404).json({ error: 'Product not found' });
    }
});

app.use((err: Error, req: Request, res: Response, next: NextFunction) => {
    console.error(err.stack);
    res.status(500).json({ error: 'Internal Server Error' });
});

app.listen(PORT, () => {
    console.log(`TypeScript server operational on port ${PORT}`);
});
