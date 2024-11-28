INSERT INTO users
  (
    id_number,
    name,
    image_profile_url,
    area,
    profile_url,
    office,
    tags,
    position_name,
    id_parent
)
VALUES
  (
    6066,
    'Ian Devling',
    'https://raw.githubusercontent.com/bumbeishvili/Assets/master/Projects/D3/Organization%20Chart/cto.jpg',
    'Corporate',
    'http://example.com/employee/profile',
    'CTO office',
    ARRAY['Ceo', 'tag1', 'manager', 'cto'],
    'CEO',
    6066
  );
