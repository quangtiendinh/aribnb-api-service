CREATE OR REPLACE VIEW public.view_listings AS
SELECT
    l.id,
    l.title,
    l.description,
    l.price_per_night,
    l.is_active,
    l.created_at AS created_at,
    l.updated_at AS updated_at,
    u.id AS host_id,
    u.username AS host_username,
    loc.id AS location_id,
    loc.country,
    loc.city,
    loc.state,
    loc.address,
    loc.postal_code,
    COALESCE(
        jsonb_agg(
        DISTINCT c.name
                 ) FILTER (WHERE c.id IS NOT NULL), '[]'::jsonb
    ) AS categories,
    COALESCE(
        jsonb_agg(
            jsonb_build_object(
                    'url', p.url,
                    'description', p.description
            )
        ) FILTER (WHERE p.id IS NOT NULL), '[]'::jsonb
    ) AS photos

FROM
    public.listings l
        LEFT JOIN public.users u ON l.host_id = u.id
        LEFT JOIN public.locations loc ON l.location_id = loc.id
        LEFT JOIN public.listings_categories lc ON lc.listing_id = l.id
        LEFT JOIN public.categories c ON lc.category_id = c.id
        LEFT JOIN public.photos p ON p.listing_id = l.id

GROUP BY
    l.id,
    u.id,
    loc.id;