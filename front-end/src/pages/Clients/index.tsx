import React, { useState } from 'react';
import { FiChevronDown, FiUser } from 'react-icons/fi';

import {
  Container,
  HeaderContainer,
  DescriptionContainer,
  DataContainer,
  ClientContainer,
} from './styles';

import Menu from '../../components/Menu';
import Button from '../../components/Button';

interface Client {
  id: string;
  name: string;
  email: string;
  phone_number: string;
  birth_date: string;
}

const Clients: React.FC = () => {
  const [selectedClient, setSelectedClient] = useState<Client>({} as Client);

  const [clients] = useState<Client[]>([
    {
      id: '01',
      name: 'Client 01',
      email: 'client01@email.com',
      phone_number: '(99)99999-9999',
      birth_date: '01/01/2000',
    },
    {
      id: '02',
      name: 'Client 02',
      email: 'client02@email.com',
      phone_number: '(99)99999-9999',
      birth_date: '01/01/2000',
    },
    {
      id: '03',
      name: 'Client 03',
      email: 'client03@email.com',
      phone_number: '(99)99999-9999',
      birth_date: '01/01/2000',
    },
    {
      id: '04',
      name: 'Client 04',
      email: 'client04@email.com',
      phone_number: '(99)99999-9999',
      birth_date: '01/01/2000',
    },
  ])

  return (
    <>
      <Menu />

      <Container>
        <HeaderContainer clientIsSelected={!!selectedClient.id}>
          <strong>Clients</strong>

          <div>
            <section>
              <h1>Manage client</h1>
              <FiChevronDown />
            </section>

            <Button>ADD +</Button>
          </div>
        </HeaderContainer>

        <DataContainer>
          <DescriptionContainer>
            <strong>Name</strong>
            <strong>E-mail</strong>
            <strong>Phone Number</strong>
            <strong>Birth Date</strong>
          </DescriptionContainer>

          <nav>
            {clients.map(client => (
              <ClientContainer
                key={client.id}
                isSelected={client.id === selectedClient.id}
                onClick={() => {
                  if (selectedClient === client) {
                    setSelectedClient({} as Client);
                  } else {
                    setSelectedClient(client);
                  }
                }}
              >
                <section>
                  <div>
                    <FiUser />
                  </div>

                  <strong>{client.name}</strong>
                </section>

                <strong>{client.email}</strong>
                <strong>{client.phone_number}</strong>
                <strong>{client.birth_date}</strong>
              </ClientContainer>
            ))}
          </nav>
        </DataContainer>
      </Container>
    </>
  );
};

export default Clients;
