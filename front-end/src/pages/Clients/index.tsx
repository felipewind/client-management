import React, { useCallback, useEffect, useRef, useState } from 'react';
import { FiChevronDown, FiUser } from 'react-icons/fi';
import { Form } from '@unform/web';
import { FormHandles } from '@unform/core';
import * as Yup from 'yup';

import { useToast } from '../../hooks/toast';

import getValidationErrors from '../../utils/getValidationErrors';

import {
  ClientAdditionContainer,
  ClientsListContainer,
  HeaderContainer,
  DescriptionContainer,
  DataContainer,
  ClientContainer,
  ManageClientPopup,
  ClientDetailsContainer,
} from './styles';

import Menu from '../../components/Menu';
import Button from '../../components/Button';
import Input from '../../components/Input';
import Loading from '../../components/Loading';
import ClientModal from '../../components/Modal/ClientModal';

export interface IClientOperationsData {
  name: string;
  email: string;
  phone_number: string;
  birth_date: string;
}

export interface Client extends IClientOperationsData {
  id: string;
}

const Clients: React.FC = () => {
  const formRef = useRef<FormHandles>(null);

  const { addToast } = useToast();

  const [loading, setLoading] = useState(false);
  const [toRefresh, setToRefresh] = useState(true);

  const [clientOpen, setClientOpen] = useState(false);
  const [openAddClient, setOpenAddClient] = useState(false);
  const [openManageClientPopup, setOpenManageClientPopup] = useState(false);

  const [selectedClient, setSelectedClient] = useState<Client>({} as Client);

  const [clients] = useState<Client[]>([
    {
      id: '01',
      name: 'Client 01',
      email: 'client01@email.com',
      phone_number: '999999999',
      birth_date: '01/01/2000',
    },
    {
      id: '02',
      name: 'Client 02',
      email: 'client02@email.com',
      phone_number: '999999999',
      birth_date: '01/01/2000',
    },
    {
      id: '03',
      name: 'Client 03',
      email: 'client03@email.com',
      phone_number: '999999999',
      birth_date: '01/01/2000',
    },
    {
      id: '04',
      name: 'Client 04',
      email: 'client04@email.com',
      phone_number: '999999999',
      birth_date: '01/01/2000',
    },
  ]);

  const handleSubmit = useCallback(
    async (data: IClientOperationsData) => {
      try {
        formRef.current?.setErrors({});

        const schema = Yup.object().shape({
          name: Yup.string().required(),
          email: Yup.string().email().required(),
          phone_number: Yup.number().required(),
          birth_date: Yup.string().required(),
        });

        await schema.validate(data, {
          abortEarly: false,
        });

        // const clientData: IClientOperationsData = {
        //   name: data.name,
        //   email: data.email,
        //   phone_number: data.phone_number,
        //   birth_date: data.birth_date,
        // };

        setLoading(true);

        // await api.post('clients', clientData);

        addToast({
          type: 'success',
          title: 'Cliente criado com sucesso',
        });

        setOpenAddClient(false);
      } catch (err) {
        if (err instanceof Yup.ValidationError) {
          const errors = getValidationErrors(err);

          formRef.current?.setErrors(errors);

          return;
        }

        addToast({
          type: 'error',
          title: 'An error occurred to add the new client',
        });
      } finally {
        setLoading(false);
      }
    },
    [addToast],
  );

  const toggleModalClient = useCallback(() => {
    setClientOpen(!clientOpen);
  }, [clientOpen]);

  useEffect(() => {
    const loadData = async () => {
      try {
        setLoading(true);

        // await api.get<Client[]>('clients').then(response => {
        //   setClients(response.data);
        // });
      } catch (err) {
        addToast({
          type: 'error',
          title: 'An error occurred to get the clients',
        });
      } finally {
        setLoading(false);
      }
    };

    if (toRefresh) {
      loadData();
      setToRefresh(false);
    }
  }, [addToast, toRefresh]);

  return (
    <>
      {loading && <Loading zIndex={1} />}

      <Menu />

      <ClientModal
        client={selectedClient}
        isOpen={clientOpen}
        setIsOpen={toggleModalClient}
        setToRefresh={setToRefresh}
      />

      {openAddClient ? (
        <ClientAdditionContainer>
          <button
            type="button"
            onClick={() =>
              setOpenAddClient(false)
            }
          >
            X
          </button>

          <strong>Add Client</strong>

          <Form ref={formRef} onSubmit={handleSubmit}>
            <section>
              <div>
                <strong>Name</strong>
                <Input name="name" type="text" placeholder="Name" />

                <strong>E-mail</strong>
                <Input name="email" type="text" placeholder="E-mail" />
              </div>

              <div>
                <strong>Phone Number</strong>
                <Input
                  name="phone_number"
                  type="number"
                  placeholder="Phone Number"
                />

                <strong>Birth Date</strong>
                <Input name="birth_date" type="text" placeholder="Birth Date" />
              </div>
            </section>

            <Button type="submit">ADD +</Button>
          </Form>
        </ClientAdditionContainer>
      ) : (
        <ClientsListContainer>
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
                    <button type="button" onClick={toggleModalClient}>
                      Edit client
                    </button>

                    <button type="button">
                      Delete client
                    </button>
                  </ManageClientPopup>
                )}
              </section>

              <Button onClick={() => {
                setSelectedClient({} as Client);
                setOpenAddClient(true);
              }}>ADD +</Button>
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
        </ClientsListContainer>
      )}

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
