import React, { useState } from 'react';
import { FiChevronDown, FiUser } from 'react-icons/fi';

import {
  Container,
  HeaderContainer,
  DescriptionContainer,
  DataContainer,
  ClientContainer,
  ManageClientPopup,
  ClientDetailsContainer,
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
  const [openManageClientPopup, setOpenManageClientPopup] = useState(false);
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
              <button
                type="button"
                onClick={() => {
                  if (!!selectedClient.id) {
                    setOpenManageClientPopup(!openManageClientPopup);
                  }
                }}
              >
                <FiChevronDown />
              </button>

              {!!selectedClient.id &&
                openManageClientPopup && (
                <ManageClientPopup>
                  <button type="button">
                    Edit client
                  </button>

                  <button type="button">
                    Delete client
                  </button>
                </ManageClientPopup>
              )}
            </section>

            <Button>ADD +</Button>
          </div>
        </HeaderContainer>

        <DataContainer clientIsSelected={!!selectedClient.id}>
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

                  setOpenManageClientPopup(false);
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

      <ClientDetailsContainer clientIsSelected={!!selectedClient.id}>
        <section>
          <div>
            <FiUser />
          </div>
        </section>

        <section>
          <article>
            <strong>Name</strong>
            <h2>{selectedClient.name}</h2>

            <strong>E-mail</strong>
            <h2>{selectedClient.email}</h2>
          </article>

          <article>
            <strong>Phone Number</strong>
            <h2>{selectedClient.phone_number}</h2>

            <strong>Birth Date</strong>
            <h2>{selectedClient.birth_date}</h2>
          </article>
        </section>
      </ClientDetailsContainer>
    </>
  );
};

export default Clients;
