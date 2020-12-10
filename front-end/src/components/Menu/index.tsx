import React, { useState } from 'react';
import { FiCodesandbox, FiUser } from 'react-icons/fi';

import { Container, OptionContainer } from './styles';

const Menu: React.FC = () => {
  const [optionSelectedIndex] = useState(1);

  return (
    <Container optionSelectedIndex={optionSelectedIndex}>
      <header>
        <FiCodesandbox />

        <strong>Client Management</strong>
      </header>

      <nav>
        <OptionContainer>
          <div>
            <FiUser />
          </div>

          <strong>Clients</strong>
        </OptionContainer>
      </nav>
    </Container>
  );
};

export default Menu;
