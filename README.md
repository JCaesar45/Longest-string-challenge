# AEGIS PRIME SYSTEMS

## Architectural Overview
A high-conversion, luxury digital storefront engineered for post-quantum hardware provisioning. The frontend operates as a zero-dependency single-page application, communicating via RESTful APIs with a polyglot microservices backend.

## Stack Specifications
- **Frontend:** HTML5, CSS3 (Glassmorphism, CSS Variables, Grid), Vanilla ES6+ (IntersectionObserver, Fetch API)
- **Backend Node 1:** Python 3.11+ (FastAPI, Pydantic, Uvicorn)
- **Backend Node 2:** Node.js 20+ (Express, TypeScript, Strict Typing)
- **Backend Node 3:** Java 21+ (Spring Boot, REST Controller, Dependency Injection)

## Execution Protocol
1. Initialize Python service: `uvicorn main:app --reload --port 8000`
2. Initialize TypeScript service: `ts-node server.ts`
3. Initialize Java service: `mvn spring-boot:run`
4. Serve `index.html` via local or production web server.

## References

Mozilla Foundation. (n.d.). *MDN Web Docs*. Retrieved September 11, 2026, from https://developer.mozilla.org/

Ramírez, S. (n.d.). *FastAPI*. Retrieved September 11, 2026, from https://fastapi.tiangolo.com/

Microsoft. (n.d.). *TypeScript Documentation*. Retrieved September 11, 2026, from https://www.typescriptlang.org/docs/

Pivotal Software, Inc. (n.d.). *Spring Boot*. Retrieved September 11, 2026, from https://spring.io/projects/spring-boot
