package com.instaclone.constant;

public class ConstantFields {
	
	public static final String RESULT = "fail";

}
//import React, { useEffect, useState } from 'react';
// import { Container, Row, Col, Button, Card, Form } from 'react-bootstrap';
// import { Link } from 'react-router-dom';
// import { FaTimes } from 'react-icons/fa'; // For clear date icon
// import { useParams } from 'react-router-dom';
// import { useGetOrderBySellerIdMutation } from '../../slices/orderApiSlice';

// const Shop = () => {

//   const sellerId = useParams()
//   const [order,setOrder] = useState([])
//   const [getOrder] = useGetOrderBySellerIdMutation();
//   useEffect(() => {
//     const getData = async () => {
//       let res = await getOrder({ entity_id:"01eae102-de82-493b-9764-ece2b38aa1a5",
//       });
//       setOrder(res && res?.data?.data?.productImages);
//     };
//     getData();
//     // eslint-disable-next-line react-hooks/exhaustive-deps
//   }, []);

//   const shopName = "Hotel Trivago";

//   // Sample data for orders
//   const orders = [
//     {
//       id: 1,
//       productName: 'Wireless Headphones',
//       productImage: 'https://via.placeholder.com/150',
//       quantity: 2,
//       overallPrice: 5000,
//       buyerPhone: '123-456-7890',
//       status: 'Shipped',
//       date: '2024-10-01',
//     },
//     {
//       id: 2,
//       productName: 'Smart Watch',
//       productImage: 'https://via.placeholder.com/150',
//       quantity: 1,
//       overallPrice: 3000,
//       buyerPhone: '987-654-3210',
//       status: 'Pending',
//       date: '2024-09-28',
//     },
//   ];

//   // State for filters
//   const [statusFilter, setStatusFilter] = useState('');
//   const [dateFilter, setDateFilter] = useState('');

//   // Filtered orders based on status and date
//   const filteredOrders = orders.filter(order => {
//     return (
//       (!statusFilter || order.status === statusFilter) &&
//       (!dateFilter || order.date === dateFilter)
//     );
//   });

//   return (
//     <Container className="mt-5 mb-5">
//       {/* Shop Info and Management Buttons */}
//       <Card
//         className="shadow-sm p-4 mb-5"
//         style={{
//           borderRadius: "18px",
//           backgroundColor: "#ffffff",
//           border: "none",
//           boxShadow: "0 8px 20px rgba(0, 0, 0, 0.1)",
//         }}
//       >
//         <Row className="align-items-center">
//           <Col xs={12} md={6} className="text-center text-md-start">
//             <h1 style={{
//               fontWeight: '700',
//               fontSize: '2rem',
//               color: '#333',
//               marginBottom: '10px',
//             }}>
//               {shopName}
//             </h1>
//           </Col>

//           <Col xs={12} md={6} className="text-center text-md-end">
//             <Link to="/manage-inventory" style={{ textDecoration: 'none', marginRight: '10px' }}>
//               <Button
//                 variant="outline-success"
//                 className="mb-3"
//                 style={{
//                   padding: '10px 20px',
//                   borderRadius: '30px',
//                   fontSize: '1rem',
//                   borderColor: '#20c997',
//                   color: '#20c997',
//                   boxShadow: '0 4px 12px rgba(32, 201, 151, 0.3)',
//                   marginRight: '10px',
//                 }}
//               >
//                 Manage Inventory
//               </Button>
//             </Link>
//             <Link to="/update-shop" style={{ textDecoration: 'none' }}>
//               <Button
//                 variant="outline-dark"
//                 className="mb-3"
//                 style={{
//                   padding: '10px 20px',
//                   borderRadius: '30px',
//                   fontSize: '1rem',
//                   borderColor: '#343a40',
//                   color: '#343a40',
//                   boxShadow: '0 4px 12px rgba(52, 58, 64, 0.2)',
//                 }}
//               >
//                 Update Shop
//               </Button>
//             </Link>
//           </Col>
//         </Row>
//       </Card>

//       {/* Order Title with Green Background */}
//       <div style={{
//         backgroundColor: '#28a745',
//         padding: '10px',
//         borderRadius: '10px',
//         marginBottom: '20px',
//         textAlign: 'center'
//       }}>
//         <h2 style={{
//           fontSize: '1.75rem',
//           fontWeight: '600',
//           color: '#fff',
//         }}>
//           Your Orders
//         </h2>
//       </div>

//       {/* Filter Section */}
//       <Card className="shadow-sm p-4 mb-3" style={{
//         borderRadius: "12px",
//         backgroundColor: "#f9f9f9",
//         border: "none",
//         boxShadow: "0 4px 10px rgba(0, 0, 0, 0.1)",
        
//       }}>
//         <Form>
//           <Row>
//             <Col md={4}>
//               <Form.Group>
//                 <Form.Label>Status</Form.Label>
//                 <Form.Control
//                   as="select"
//                   value={statusFilter}
//                   onChange={(e) => setStatusFilter(e.target.value)}
//                 >
//                   <option value="">All</option>
//                   <option value="Shipped">Shipped</option>
//                   <option value="Pending">Pending</option>
//                 </Form.Control>
//               </Form.Group>
//             </Col>
//             <Col md={4}>
//               <Form.Group>
//                 <Form.Label>Date</Form.Label>
//                 <div style={{ display: 'flex', alignItems: 'center' }}>
//                   <Form.Control
//                     type="date"
//                     value={dateFilter}
//                     onChange={(e) => setDateFilter(e.target.value)}
//                   />
//                   {dateFilter && (
//                     <Button
//                       variant="light"
//                       onClick={() => setDateFilter('')}
//                       style={{ marginLeft: '10px' }}
//                     >
//                       <FaTimes />
//                     </Button>
//                   )}
//                 </div>
//               </Form.Group>
//             </Col>
//           </Row>
//         </Form>
//       </Card>

//       {/* Seller Orders Section */}
//       <div style={{ padding: '10px' }}>
//         {filteredOrders.length > 0 ? (
//           filteredOrders.map(order => (
//             <Card
//               key={order.id}
//               style={{
//                 display: 'flex',
//                 flexDirection: 'row',
//                 marginBottom: '20px',
//                 border: '1px solid #e0e0e0',
//                 backgroundColor: 'white',
//                 borderRadius: '8px',
//                 transition: 'transform 0.3s ease-in-out',
//                 boxShadow: '0 4px 8px rgba(0, 0, 0, 0.1)',
//                 cursor: 'pointer',
//                 overflow: 'hidden'
//               }}
//               onMouseEnter={e => e.currentTarget.style.transform = 'scale(1.02)'}
//               onMouseLeave={e => e.currentTarget.style.transform = 'scale(1)'}
//             >
//               <div style={{ flex: '0 0 150px', overflow: 'hidden' }}>
//                 <img
//                   src={order.productImage}
//                   alt={order.productName}
//                   style={{
//                     width: '100%',
//                     height: '100%',
//                     objectFit: 'cover',
//                   }}
//                 />
//               </div>

//               <div style={{
//                 flex: '1',
//                 padding: '10px 20px',
//                 display: 'flex',
//                 flexDirection: 'column',
//                 justifyContent: 'space-between',
//                 gap: '10px'
//               }}>
//                 <div>
//                   <h5 style={{ marginBottom: '8px', fontSize: '1.1rem', fontWeight: '600' }}>{order.productName}</h5>
//                   <p style={{ marginBottom: '4px', color: '#555', fontSize: '0.95rem' }}>Quantity: {order.quantity}</p>
//                   <p style={{ marginBottom: '4px', color: '#555', fontSize: '0.95rem' }}>Overall Price: ₹{order.overallPrice}</p>
//                   <p style={{ marginBottom: '4px', color: '#555', fontSize: '0.95rem' }}>Buyer Phone: {order.buyerPhone}</p>
//                 </div>

//                 <div style={{
//                   display: 'flex',
//                   justifyContent: 'space-between',
//                   alignItems: 'center',
//                   paddingTop: '8px',
//                   borderTop: '1px solid #eee'
//                 }}>
//                   <Button
//                     as={Link}
//                     to={`/admin/orderDetail/${order.id}`}
//                     variant="success"
//                     style={{
//                       backgroundColor: '#28a745',
//                       borderColor: '#28a745',
//                       padding: '5px 12px',
//                       fontSize: '0.85rem',
//                     }}
//                   >
//                     View Details
//                   </Button>
//                   <p style={{
//                     margin: '0',
//                     fontWeight: 'bold',
//                     fontSize: '0.9rem',
//                     color: order.status === 'Shipped' ? 'green' : 'orange'
//                   }}>
//                     {order.status}
//                   </p>
//                 </div>
//               </div>
//             </Card>
//           ))
//         ) : (
//           <p className="text-center">You have no orders yet.</p>
//         )}
//       </div>
//     </Container>
//   );
// };

// export default Shop;
