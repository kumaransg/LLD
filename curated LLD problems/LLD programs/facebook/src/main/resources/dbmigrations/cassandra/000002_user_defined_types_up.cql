CREATE TYPE IF NOT EXISTS comment_liked_by_type (entity_id uuid, entity_name text, name text, thumbnail_url text);

CREATE TYPE IF NOT EXISTS connection_type (entity_id uuid, entity_name text, name text, thumbnail_url text);

CREATE TYPE IF NOT EXISTS comment_posted_by_type (entity_id uuid, entity_name text, name text, thumbnail_url text);

CREATE TYPE IF NOT EXISTS building_type (entity_id uuid, entity_name text, latitude text, longitude text, name text, thumbnail_url text);

CREATE TYPE IF NOT EXISTS district_type (entity_id uuid, entity_name text, latitude text, longitude text, name text, thumbnail_url text);

CREATE TYPE IF NOT EXISTS country_type (entity_id uuid, entity_name text, latitude text, longitude text, name text, thumbnail_url text);

CREATE TYPE IF NOT EXISTS person_page_type (entity_id uuid, entity_name text, name text, thumbnail_url text);

CREATE TYPE IF NOT EXISTS comment_posted_by_type (entity_id uuid, entity_name text, name text, thumbnail_url text);

CREATE TYPE IF NOT EXISTS sub_district_type (entity_id uuid, entity_name text, latitude text, longitude text, name text, thumbnail_url text);

CREATE TYPE IF NOT EXISTS group_member_type (entity_id uuid, entity_name text, name text, thumbnail_url text);

CREATE TYPE IF NOT EXISTS following_type (entity_id uuid, entity_name text, name text, thumbnail_url text);

CREATE TYPE IF NOT EXISTS person_liked_post_type (entity_id uuid, entity_name text, name text, posted_by_entity_id uuid, thumbnail_url text);

CREATE TYPE IF NOT EXISTS city_type (entity_id uuid, entity_name text, latitude text, longitude text, name text, thumbnail_url text);

CREATE TYPE IF NOT EXISTS location_type (entity_id uuid, entity_name text, latitude text, longitude text, name text, thumbnail_url text);

CREATE TYPE IF NOT EXISTS follower_type (entity_id uuid, entity_name text, name text, thumbnail_url text);

CREATE TYPE IF NOT EXISTS apartment_type (entity_id uuid, entity_name text, latitude text, longitude text, name text, thumbnail_url text);

CREATE TYPE IF NOT EXISTS area_type (entity_id uuid, entity_name text, latitude text, longitude text, name text, thumbnail_url text);

CREATE TYPE IF NOT EXISTS person_shared_post_type (entity_id uuid, entity_name text, name text, posted_by_entity_id uuid, thumbnail_url text);

CREATE TYPE IF NOT EXISTS house_type (entity_id uuid, entity_name text, latitude text, longitude text, name text, thumbnail_url text);

CREATE TYPE IF NOT EXISTS post_liked_by_type (entity_id uuid, entity_name text, name text, thumbnail_url text);

CREATE TYPE IF NOT EXISTS page_admin_type (entity_id uuid, entity_name text, name text, thumbnail_url text);

CREATE TYPE IF NOT EXISTS pincode_type (entity_id uuid, entity_name text, latitude text, longitude text, name text, thumbnail_url text);

CREATE TYPE IF NOT EXISTS police_station_type (entity_id uuid, entity_name text, latitude text, longitude text, name text, thumbnail_url text);

CREATE TYPE IF NOT EXISTS comment_posted_on_type (entity_id uuid, entity_name text, name text, thumbnail_url text);

CREATE TYPE IF NOT EXISTS comment_type (comment text, comment_id uuid, comment_liked_by frozen<comment_liked_by_type>, comment_posted_by frozen<comment_posted_by_type>, comment_posted_on frozen<comment_posted_on_type>);

CREATE TYPE IF NOT EXISTS address_type (apartment frozen<apartment_type>, apartment_name text, area frozen<area_type>, area_name text, building frozen<building_type>, building_number text, city frozen<city_type>, city_name text, country frozen<country_type>, country_name text, district frozen<district_type>, district_name text, house frozen<house_type>, house_number text, pincode frozen<pincode_type>, pincode_number text, police_station frozen<police_station_type>, police_station_name text, state frozen<state_type>, state_name text, sub_district frozen<sub_district_type>, sub_district_name text);