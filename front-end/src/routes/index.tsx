import React from 'react';
import { Redirect, Route, Switch } from 'react-router-dom';

import Clients from '../pages/Clients';

const Routes: React.FC = () => (
  <Switch>
    <Redirect exact from="/" to="/clients" />

    <Route path="/clients" component={Clients} />
  </Switch>
);

export default Routes;
