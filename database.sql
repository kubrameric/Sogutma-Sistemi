PGDMP     -    8                x            NYAT    12.2    12.2     
           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    16393    NYAT    DATABASE     �   CREATE DATABASE "NYAT" WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Turkish_Turkey.1254' LC_CTYPE = 'Turkish_Turkey.1254';
    DROP DATABASE "NYAT";
                postgres    false            �            1259    16399    AkilliCihaz    TABLE     c   CREATE TABLE public."AkilliCihaz" (
    "Id" integer NOT NULL,
    "CihazAdi" character varying
);
 !   DROP TABLE public."AkilliCihaz";
       public         heap    postgres    false            �            1259    16394    Kullanicilar    TABLE     �   CREATE TABLE public."Kullanicilar" (
    "kullaniciNo" integer NOT NULL,
    "kullaniciAdi" character varying(100) NOT NULL,
    sifre character varying(100) NOT NULL,
    "akilliCihaz" integer NOT NULL
);
 "   DROP TABLE public."Kullanicilar";
       public         heap    postgres    false                      0    16399    AkilliCihaz 
   TABLE DATA           9   COPY public."AkilliCihaz" ("Id", "CihazAdi") FROM stdin;
    public          postgres    false    203   �                 0    16394    Kullanicilar 
   TABLE DATA           ]   COPY public."Kullanicilar" ("kullaniciNo", "kullaniciAdi", sifre, "akilliCihaz") FROM stdin;
    public          postgres    false    202   �       �
           2606    16406    AkilliCihaz AkilliCihaz_pkey 
   CONSTRAINT     `   ALTER TABLE ONLY public."AkilliCihaz"
    ADD CONSTRAINT "AkilliCihaz_pkey" PRIMARY KEY ("Id");
 J   ALTER TABLE ONLY public."AkilliCihaz" DROP CONSTRAINT "AkilliCihaz_pkey";
       public            postgres    false    203            �
           2606    16398    Kullanicilar Kullanicilar_pkey 
   CONSTRAINT     k   ALTER TABLE ONLY public."Kullanicilar"
    ADD CONSTRAINT "Kullanicilar_pkey" PRIMARY KEY ("kullaniciNo");
 L   ALTER TABLE ONLY public."Kullanicilar" DROP CONSTRAINT "Kullanicilar_pkey";
       public            postgres    false    202            �
           1259    16412    fki_baglanti    INDEX     P   CREATE INDEX fki_baglanti ON public."Kullanicilar" USING btree ("akilliCihaz");
     DROP INDEX public.fki_baglanti;
       public            postgres    false    202            �
           2606    16413    Kullanicilar akilliCihaz    FK CONSTRAINT     �   ALTER TABLE ONLY public."Kullanicilar"
    ADD CONSTRAINT "akilliCihaz" FOREIGN KEY ("akilliCihaz") REFERENCES public."AkilliCihaz"("Id") NOT VALID;
 F   ALTER TABLE ONLY public."Kullanicilar" DROP CONSTRAINT "akilliCihaz";
       public          postgres    false    202    2694    203                  x�3�LLL����� �         =   x�3��.M*J�M-�L�442615�4�2�
�@C.c�ĜL06�2�,K2��!W� s�a     