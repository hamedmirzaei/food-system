import React, { useState, useEffect } from 'react';
import axios from 'axios';

function RestaurantsList() {
    const [data, setData] = useState([]);

    useEffect(() => {
        axios.get('/api/v1/restaurants')
            .then(response => {
                setData(response.data);
            })
            .catch(error => {
                console.log('An error happened in fetching restaurants')
                console.error(error);
            });
    }, []);

    return (
        <div>
            <h1>My Data:</h1>
            <ul>
                {data.map((restaurant) => (
                    <li key={restaurant.id}>{restaurant.name}</li>
                ))}
            </ul>
        </div>
    );
}

export default RestaurantsList;