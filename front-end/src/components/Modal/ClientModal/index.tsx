import React, { useCallback, useRef, useState } from 'react';
import { FormHandles } from '@unform/core';
import { Form } from '@unform/web';
import * as Yup from 'yup';

import getValidationErrors from '../../../utils/getValidationErrors';

import { useToast } from '../../../hooks/toast';

import Modal from '..';
import Loading from '../../Loading';
import Input from '../../Input';
import Button from '../../Button';

import { Container } from './styles';

import { IClientOperationsData, Client } from '../../../pages/Clients';

interface IModalProps {
  client: Client;
  isOpen: boolean;
  setIsOpen: () => void;
  setToRefresh: React.Dispatch<React.SetStateAction<boolean>>;
}

const ClientModal: React.FC<IModalProps> = ({
  client,
  isOpen,
  setIsOpen,
  setToRefresh,
}) => {
  const formRef = useRef<FormHandles>(null);

  const [loading, setLoading] = useState(false);

  const { addToast } = useToast();

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

        // await api.put(`clients/${client.id}`, clientData);

        addToast({
          type: 'success',
          title: 'Client altered successfully',
        });

        setIsOpen();
        setToRefresh(true);
      } catch (err) {
        if (err instanceof Yup.ValidationError) {
          const errors = getValidationErrors(err);

          formRef.current?.setErrors(errors);

          return;
        }

        addToast({
          type: 'error',
          title: 'An error occurred to edit the client',
        });
      } finally {
        setLoading(false);
      }
    },
    [addToast, client.id, setIsOpen, setToRefresh],
  );

  return (
    <>
      {loading && <Loading zIndex={1} />}

      <Modal isOpen={isOpen} setIsOpen={setIsOpen}>
        <Container>
          <strong>Edit Client</strong>
          <button
            type="button"
            onClick={setIsOpen}
          >
            X
          </button>

          <Form ref={formRef} onSubmit={handleSubmit}>
            <section>
              <div>
                <strong>Name</strong>
                <Input
                  name="name"
                  type="text"
                  placeholder="Name"
                  defaultValue={client.name}
                />

                <strong>E-mail</strong>
                <Input
                  name="email"
                  type="text"
                  placeholder="E-mail"
                  defaultValue={client.email}
                />
              </div>

              <div>
                <strong>Phone Number</strong>
                <Input
                  name="phone_number"
                  type="number"
                  placeholder="Phone Number"
                  defaultValue={client.phone_number}
                />

                <strong>Birth Date</strong>
                <Input
                  name="birth_date"
                  type="text"
                  placeholder="Birth Date"
                  defaultValue={client.birth_date}
                />
              </div>
            </section>

            <Button type="submit">SAVE</Button>
          </Form>
        </Container>
      </Modal>
    </>
  );
};

export default ClientModal;
